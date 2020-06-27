package com.pykj.tomcat.dautils;

public class DbUtils {

    public static void main(String[] args) {

        /*try{
            ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
            Connection connection = dataSource.getConnection();
            List<Users> usersList = new ArrayList<>();
            int id = 100;
            String sql = "select  * from users where id = ?";
            QueryRunner queryRunner = new QueryRunner();
            usersList = queryRunner.query(connection,sql,new BeanListHandler<>(Users.class),id);
            for (Users u:usersList) {
                System.out.println("id:" + u.getId() + ",email:" + u.getEmail() + ",nickName:" + u.getNick_name() );
            }
            connection.close();
        }catch (Exception e) {
            e.printStackTrace();
        }*/
        //extends Number implements Comparable<Float>
        Byte.valueOf("1");
        Short.valueOf("1");
        Integer.valueOf(1);
        Long.valueOf("1");
        Float.valueOf("1");//这个没有cache
        Double.valueOf("1");//这个也没有cache
        Character.valueOf('1');
        Boolean.valueOf(true);//这个也没有cache


    }

}
