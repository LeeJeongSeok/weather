package com.zerobase.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.zerobase.weather.domain.Memo;
import com.zerobase.weather.repository.JpaMemoRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {

	@Autowired
	JpaMemoRepository jpaMemoRepository;

	@Test
	void insertMemoTest() {
		// given
		Memo newMemo = new Memo(3, "this is new Memo~");

		// when
		jpaMemoRepository.save(newMemo);

		// then
		List<Memo> memoList = jpaMemoRepository.findAll();
		assertTrue(memoList.size() > 0);
		//assertEquals()

	}

	@Test
	void findByIdTest() {
		// given
		Memo newMemo = new Memo(11, "jpa");

		// when
		Memo memo = jpaMemoRepository.save(newMemo);

		// then
		Optional<Memo>result = jpaMemoRepository.findById(memo.getId());
		assertEquals(result.get().getText(), "jpa");

	}
}
