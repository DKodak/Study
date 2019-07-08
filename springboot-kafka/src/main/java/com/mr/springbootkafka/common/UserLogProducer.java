package com.mr.springbootkafka.common;

import com.alibaba.fastjson.JSON;
import com.mr.springbootkafka.entity.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Kodak
 * @company 沐融
 * @create 2019-07-08 -15:07
 */
@Component
public class UserLogProducer {
	@Autowired
	private KafkaTemplate kafkaTemplate;

	/**
	 * 发送数据
	 * 定义消息的发送者
	 * @param userid
	 */
	public void sendLog(String userid){
		UserLog userLog = new UserLog();
		userLog.setUsername("jhp").setUserid(userid).setState("0");
		System.err.println("发送用户日志数据:"+userLog);
		kafkaTemplate.send("user-log", JSON.toJSONString(userLog));
	}

}
