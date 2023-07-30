package com.code.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.code.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		
		String className = this.userRepo.getClass().getName();
		
		String packageName = this.userRepo.getClass().getPackageName();
		
		System.out.println("ClassName" + className);
		System.out.println("PackageName" + packageName);
		
	}
}
