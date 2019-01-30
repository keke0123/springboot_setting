package com.socket.project.domain.test;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity클래스, PK타입> 을 상속하면
// 기본적인 CRUD 메소드가 자동생성된다.
public interface TestsRepository extends JpaRepository<Tests, Long>{

}
