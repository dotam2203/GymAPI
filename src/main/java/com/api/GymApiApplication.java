package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class GymApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(GymApiApplication.class, args);
	}
}
