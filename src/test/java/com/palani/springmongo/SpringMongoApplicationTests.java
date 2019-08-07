package com.palani.springmongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.palani.springmongo.SpringMongoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringMongoApplication.class)
public class SpringMongoApplicationTests {

	@Test
	public void applicationContextTest() {
		SpringMongoApplication.main(new String[] {});
	}

}
