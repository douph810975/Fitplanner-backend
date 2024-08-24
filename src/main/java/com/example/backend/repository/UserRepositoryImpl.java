//package com.example.backend.repository;
//
//import com.example.backend.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Repository
//public class UserRepositoryImpl implements UserRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Optional<User> findByUsername(String username) {
//        try {
//            User user = entityManager.createQuery("SELECT u FROM users u WHERE u.username = :username", User.class)
//                    .setParameter("username", username)
//                    .getSingleResult();
//            return Optional.of(user);
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    @Transactional
//    public void save(User user) {
//        if (user.getId() == null) {
//            entityManager.persist(user);
//        } else {
//            entityManager.merge(user);
//        }
//    }
//
//    // 其他方法的实现
//}
