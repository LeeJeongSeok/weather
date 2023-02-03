package com.zerobase.weather;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.zerobase.weather.domain.Memo;
import com.zerobase.weather.repository.JdbcMemoRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class JdbcMemoRepositoryTest {

	@Autowired
	JdbcMemoRepository jdbcMemoRepository;

	@Test
	void insertMemoTest() {
		// given
		Memo newMemo = new Memo(2, "this is new Memo~");

		// when
		jdbcMemoRepository.save(newMemo);

		// then
		Optional<Memo> result = jdbcMemoRepository.findById(2);
		assertEquals(result.get().getText(), "this is new Memo~");

	}

	@Test
	void findAllMemoTest() {
		List<Memo> memoList = jdbcMemoRepository.findAll();
		assertNotNull(memoList);

	}
}
