package com.websocket.demo.websocket_demo.controller.v6;

import com.websocket.demo.websocket_demo.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/13 4:31
 */
@Controller
public class UserChatController {

    @Autowired
    private WebSocketService ws;

    //模拟数据库用户的数据
    public static Map<String, String> userMap = new HashMap<String, String>();

    static{
        userMap.put("jack", "123");
        userMap.put("mary", "456");
        userMap.put("tom", "789");
        userMap.put("lucy", "000");
        userMap.put("elvis", "666");

    }

    //在线用户存储
    public static Map<String, User> onlineUser = new HashMap<>();
    static{
        onlineUser.put("123",new User("admin","888"));
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String userLogin(@RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "pwd", required = true) String pwd,HttpSession session){

        String password = userMap.get(username);
        if (pwd.equals(password)){
            User user = new User(username, pwd);
            String sessionId = session.getId();
            onlineUser.put(sessionId, user);
            return "redirect:/v6/chat.html";
        } else{
            return "redirect:/v6/error.html";
        }
    }
}
