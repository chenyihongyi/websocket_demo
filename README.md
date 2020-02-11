1.websocket广播：
单播(Unicast)
   点对点，私信私聊
   
 广播(Broadcast)
 游戏公告
 
 多播(Multicast)
 多人聊天，发布订阅
 
 官方文档: https://spring.io/guides/gs/messaging-stomp-websocket/
 
 2.websocket推送方法讲解
 @SendTo注解和SimpMessagingTemplate的区别
 
 1.SendTo 不通用，固定发送给指定的订阅者 v1版本
 2.SimMessagingTemplate 灵活，支持多种发送方式
 
 在controller的类的方法上标注@Scheduled(fixedRate = 3000)  表示这个方法会定时3s执行
 
 
 
 
 