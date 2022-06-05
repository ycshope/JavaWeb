package com.kali.aop.jdkproxy;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add running...");
        return a + b;
    }

    @Override
    public void update(String id) {
        System.out.println("update running..." + id);
    }
}
