package cc.aicode.e2e.repository;

import cc.aicode.e2e.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zombi on 2018/3/3.
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {
}
