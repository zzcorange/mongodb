package com.chengzi.mongodb;

import com.chengzi.mongodb.other.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void contextLoads() {
        UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        mongoTemplate.insert(user);
    }
    @Test
    public void testUpdate(){
        UserEntity user=new UserEntity();
        user.setId(2l);
        user.setUserName("小明update");
        user.setPassWord("fffooo123");
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is("小明"));
        Update update = new Update().set("userName","小明update");
        mongoTemplate.updateFirst(query,update,user.getClass());
    }
    @Test
    public void testSelect(){
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").alike());
        System.out.println(mongoTemplate.find(query,UserEntity.class));
    }
    @Test
    public void testSave(){
        for(int i=0;i<20;i++){
            UserEntity user=new UserEntity();
            user.setId(Long.valueOf(i+""));
            user.setUserName("姓名"+i);
            user.setPassWord("password"+i);
            mongoTemplate.save(user);
        }
    }
}
