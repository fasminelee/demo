package com.fas.demo.repository;

import com.fas.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    void deleteById(Long id);

    User findByUserName(String userName);

    User findByEmail(String email);

    User findByUserNameOrEmail(String username, String email);

    //And --- 等价于 SQL 中的 and 关键字，比如 findByUserNameAndPassword(int height,char sex)；
    public List<User> findByUserNameAndPassword(String userName, String password);

    // Or --- 等价于 SQL 中的 or 关键字，比如:
    public List<User> findByUserNameOrNickName(String userName, String nickName);

    //Between --- 等价于 SQL 中的 between 关键字，比如:
    public List<User> findByAgeBetween(int min, int max);

    //LessThan --- 等价于 SQL 中的 "<"，比如:
    public List<User> findByAgeLessThan(int max);

    //GreaterThan --- 等价于 SQL 中的">"，比如:
    public List<User> findByAgeGreaterThan(int min);

    //IsNull --- 等价于 SQL 中的 "is null"，比如:
    public List<User> findByUserNameIsNull();

    //IsNotNull --- 等价于 SQL 中的 "is not null"，比如:
    public List<User> findByUserNameIsNotNull();

    //NotNull --- 与 IsNotNull 等价；
    public List<User> findByUserNameNotNull();

    //Like --- 等价于 SQL 中的 "like"，比如:
    public List<User> findByUserNameLike(String name);

    //NotLike --- 等价于 SQL 中的 "not like"，比如:
    public List<User> findByUserNameNotLike(String name);

    //OrderBy --- 等价于 SQL 中的 "order by"，比如:
    public List<User>findByUserNameNotNullOrderByAgeAsc();

    //Not --- 等价于 SQL 中的 "！ ="，比如:
    public List<User> findByUserNameNot(String name);

    //In --- 等价于 SQL 中的 "in"，比如:
    public List<User> findByUserNameIn(String name);

    //NotIn --- 等价于 SQL 中的 "not in"，比如:
    public List<User> findByUserNameNotIn(String name);


    // where name like ?% and age <?
    public List<User> findByUserNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name like %? and age <?
    public List<User> findByUserNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in (?,?....) or age <?
    public List<User> findByUserNameInOrAgeLessThan(List<String> names, Integer age);

    // where name in (?,?....) and age <?
    public List<User> findByUserNameInAndAgeLessThan(List<String> names, Integer age);

//    @Query("select o from User o where id=(select max(id) from User t1)")
//    public User getEmployeeByMaxId();
//
//    @Query("select o from User o where o.name=?1 and o.age=?2")
//    public List<User> queryParams1(String name, Integer age);
//
//    @Query("select o from User o where o.name=:name and o.age=:age")
//    public List<User> queryParams2(@Param("name") String name, @Param("age") Integer age);
//
//    @Query("select o from User o where o.name like %?1%")
//    public List<User> queryLike1(String name);
//
//    @Query("select o from User o where o.name like %:name%")
//    public List<User> queryLike2(@Param("name") String name);
//
//    @Query(nativeQuery = true, value = "SELECT count(1) FROM employee")
//    public long getCount();
//
//    @Modifying
//    @Query("update Employee o set o.age = :age where o.id = :id")
//    public void update(@Param("id") Integer id, @Param("age") Integer age);
//
//    @Query("select o FROM User o WHERE o.id=:id")
//    User findUserById(@Param("id") Long id);
//
//    @Query("select u FROM User u WHERE u.userName=?1 AND u.password IS NOT NULL")
//    List<User> findAll(String userName);
//
//
//    @Query("DELETE FROM User u WHERE u.userName=?1")
//    @Modifying
//    @Transactional
//    void deleteByUserName(String userName);
//
//    @Query("UPDATE User u SET u.email= :email WHERE u.userName = :user")
//    @Modifying
//    @Transactional
//    void updateEmail(@Param("user") String userName, @Param("email") String email);
}