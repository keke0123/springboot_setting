package com.socket.project.domain.test;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JpaRepository<Entity클래스, PK타입> 을 상속하면
// 기본적인 CRUD 메소드가 자동생성된다.
public interface TestsRepository extends JpaRepository<Tests, Long>{
	// 실제 아래 코드는 기본 메소드로 해결 가능하지만
	// query 작성 예제로 써둠
	@Query("SELECT p "+
			"FROM Tests p "+
			"ORDER BY p.id DESC")
	Stream<Tests> findAllDesc();
}
