package com.microservice.user.service;

import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import com.microservice.user.valueobject.Department;
import com.microservice.user.valueobject.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside UserService.saveUser method");
        return userRepository.save(user);
    }

    public ResponseTemplateVO findUserWithDepartmentById(Long userId) {
        log.info("Inside UserService.findUserWithDepartmentById method");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +
                user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
