package com.mr.springbootkafka.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Kodak
 * @company 沐融
 * @create 2019-07-08 -15:07
 */
@Data
@Accessors(chain = true)
public class UserLog {
	/**
	 * 定义一个bean用来发送消息的载体
	 */
	private String username;
	private String userid;
	private String state;
}
