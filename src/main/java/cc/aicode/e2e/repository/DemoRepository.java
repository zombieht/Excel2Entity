package cc.aicode.e2e.repository;

import cc.aicode.e2e.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zombi on 2018/3/3.
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {

    List<Demo> findAllByCargoOrCargoOrCargo(String px, String sm ,String ben);
}
