package com.pykj.spring.boot.xmg.web.repository;

import com.pykj.spring.boot.xmg.web.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

    private final AtomicLong idGenerator = new AtomicLong();

    public Boolean save(User user) {
        //并发包
        long id = idGenerator.incrementAndGet();
        System.out.println("获取id" + id);
        //map.put(1,"2")
        //map.put(1,"3")
        //第二个map.put会返回第一个map.put的value
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }

}
