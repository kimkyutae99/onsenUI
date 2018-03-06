package org.zerock.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class BoardDAOTest {

  @Inject
  private BoardDAO dao;

  private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

  @Test
  public void testCreate() throws Exception {

    BoardVO board = new BoardVO();
    board.setTitle("1111");
    board.setContent("22222");
    board.setWriter("user00");
    dao.create(board);
  }

 @Test
  public void testRead() throws Exception {

    logger.info(dao.read(3).toString());
  }

  @Test
  public void testUpdate() throws Exception {

    BoardVO board = new BoardVO();
    board.setBno(2);
    board.setTitle("333333");
    board.setContent("444444");
    dao.update(board);
  }

  @Test
  public void testDelete() throws Exception {

    dao.delete(2);
  }

  @Test
  public void testListPage()throws Exception{
	  int page = 3;
	  List<BoardVO> list = dao.listPage(page);
	  
	  for(BoardVO boardVO : list) {
		  logger.info(boardVO.getBno()+":"+boardVO.getTitle());
	  }
  }

}
