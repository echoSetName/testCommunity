package com.example.community.cache;

import com.example.community.dto.tagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<tagDTO> get(){
        ArrayList<tagDTO> tagDTOS = new ArrayList<>();
        tagDTO program = new tagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js","php","css","css3","html","html5","java","node.js","python","c++","c","golang","objective-c","typescript","shell","swift","c#","sass","ruby","bash","less","asp.net","lua","scala","coffeescript","rust","erlang","perl"));
        tagDTOS.add(program);

        tagDTO framework = new tagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("laravel","spring","express","django","flask","yii","ruby-on-rails","tornado","koa","struts"));
        tagDTOS.add(framework);

        tagDTO server = new tagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux","nginx","docker","apache","ubuntu","centos","缓存","tomcat","负载均衡","unix","hadoop","windos-server"));
        tagDTOS.add(server);

        tagDTO db = new tagDTO();
        db.setCategoryName("数据库与缓存");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","oracle","nosql","memcached","sqlserver","postgresql","sqlite"));
        tagDTOS.add(db);

        tagDTO tools = new tagDTO();
        tools.setCategoryName("开发工具");
        tools.setTags(Arrays.asList("git","github","visual-studio-code","vim","sublime-text","xcode","intellij-idea","eclipse","maven","ide","svn","visual-studio","atom","emacs","textmate","hg"));
        tagDTOS.add(tools);

        tagDTO systems = new tagDTO();
        systems.setCategoryName("系统设备");
        systems.setTags(Arrays.asList("android","ios","chrome","windows","iphone","firefox","internet-explorer","safari","ipad","opera","apple-watch"));
        tagDTOS.add(systems);

        return tagDTOS;
    }

    public static String filterInvalid(String tags){
        String[] split = StringUtils.split(tags,",");
        List<tagDTO> tagDTOS = get();

        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String  invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
