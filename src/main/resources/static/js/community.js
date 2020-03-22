/**
 * 提交回复
 */
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2target(questionId, 1, content);
}

function comment2target(targetId, targetType, content){
    if (!content) {
        alert("不能回复空内容~~~");
        return;
    }


    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": targetType
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            }
            else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=Iv1.8d431d6cd9658e85&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                }
                else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    })
}

function comment(e){
    var commentId = e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2target(commentId, 2, content)
}
/**
 * 展开折叠二级评论
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-"+id);

    if (comments.hasClass("in")) {
        comments.removeClass("in");
        e.classList.remove("active");
    }
    else {
        var subCommentContainer = $("#comment-"+id);
        if(subCommentContainer.children().length != 1){
            //展开二级评论
            comments.addClass("in");
            //标记二级评论展开状态
            e.classList.add("active");
        }
        else{
        /*<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" th:each="comment : ${comments}">
                <div class="media">
                <div class="media-left">
                <a href="#">
                <img class="media-object img-rounded"
            th:src="${comment.user.avatarUrl}">
                </a>
                </div>
                <div class="media-body">
                <h5 class="media-heading">
                <span th:text="${comment.user.name}"></span>
                </h5>
                &lt;!&ndash;回复内容&ndash;&gt;
        <div th:text="${comment.content}"></div>
                <div class="community-menu">
                <span class="pull-right"
            th:text="${#dates.format(comment.gmtCreate, 'yyyy-MM-dd')}"></span>
                </div>
                </div>
                </div>
                </div>*/
            $.getJSON("/comment/"+id, function(data){
                $.each(data.data.reverse(), function(index, comment){

                    var mediaBodyElement = $("<div/>",{
                        "class" : "media-body"
                    }).append($("<h5/>",{
                        "class" : "media-heading",
                        "html" : comment.user.name
                    })).append($("<div/>",{
                        "html" : comment.content
                    })).append($("<div/>",{
                        "class" : "community-menu"
                    }).append($("<span/>",{
                        "class" : "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));


                    var aElement = $("<a/>",{
                        "href" : "#"
                    }).append($("<img/>",{
                        "class" : "media-object img-rounded",
                        "src" : comment.user.avatarUrl
                    }));
                    var mediaLeftElement = $("<div/>",{
                        "class" : "media-left"
                    }).append(aElement);


                    var mediaElement = $("<div/>",{
                       "class" : "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    var commentElement = $("<div/>",{
                        "class" : "col-lg-12 col-md-12 col-sm-12 col-xs-12 commentInfo"
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论
                comments.addClass("in");
                //标记二级评论展开状态
                e.classList.add("active");
            })
        }
    }
}


function selectTag(e){
    var previous = $("#tag").val();
    var value = e.getAttribute("data-tag");

    if(previous.indexOf(value) == -1){
        if (previous){
            $("#tag").val(previous + ',' + value);
        }
        else{
            $("#tag").val(value);
        }
    }
}

function showSelectTag(){
    var selectTag = $("#select-tag");
    selectTag.show();
}
