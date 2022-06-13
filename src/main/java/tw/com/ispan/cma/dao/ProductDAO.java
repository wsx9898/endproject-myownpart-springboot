package tw.com.ispan.cma.dao;

import tw.com.ispan.cma.domain.ProductBean;

import java.util.List;

public interface ProductDAO {

	ProductBean select(Integer id);

	List<ProductBean> select();

	List<ProductBean> select(String pdname, String pdtype);

	ProductBean insert(ProductBean bean);

	ProductBean update(String name, Integer price,
									   String desc, String catalog, Integer id);

	ProductBean updateImg(String imgIndex, Integer id);

	boolean delete(Integer id);

}