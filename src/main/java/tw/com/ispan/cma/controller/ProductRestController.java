package tw.com.ispan.cma.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.com.ispan.cma.domain.ProductBean;
//import tw.com.ispan.cma.service.ProductReositoryService;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( path = {"/public/api"}	)
public class ProductRestController {
//	@Autowired
//	private ProductReositoryService productReositoryService;
//
//	@GetMapping( path = {"/products"} )
//	public ResponseEntity<List<ProductBean>> findAll() {
////		成功：200 (OK)、message body包含所有resource資料
//		List<ProductBean> beans = productReositoryService.select(null);
//		return ResponseEntity.ok().body(beans);
//	}
//
//	@GetMapping(path = {"/products/{id}"})
//	public ResponseEntity<?> findByPrimaryKey(@PathVariable(name = "id") Integer id) {
////		成功：200 (OK)、message body包含1個resource的資料
////		失敗(resource不存在)：404 (Not Found)
////		失敗(resource id格式錯誤)：400 (Bad Request)
//
//		ProductBean bean = new ProductBean();
//		bean.setId(id);
//		List<ProductBean> select = productReositoryService.select(bean);
//		if(select!=null && !select.isEmpty()) {
//			ProductBean product = select.get(0);
//			ResponseEntity<ProductBean> entity = ResponseEntity.ok().body(product);
//			return entity;
//		} else {
//			ResponseEntity<?> entity = ResponseEntity.notFound().build();
//			return entity;
//		}
//	}
//
//	@PostMapping("/products")
//	public ResponseEntity<?> create(@RequestBody String body) {
////		新增：POST message body包含需要新增的resource資料
////		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
////		失敗：204 (No Content)
//		JSONObject jsonObj = new JSONObject(body);
//		Date date = null;
//		try {
//			String make = jsonObj.getString("make");
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(make);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ProductBean bean = new ProductBean();
//		bean.setId(jsonObj.getInt("id"));
//		bean.setName(jsonObj.getString("name"));
//		bean.setPrice(jsonObj.getDouble("price"));
//		bean.setMake(date);
//		bean.setExpire(jsonObj.getInt("expire"));
//
//		ProductBean insert = productReositoryService.insert(bean);
//		if(insert!=null) {
//			URI uri = URI.create("/public/api/products/"+insert.getId());
//			ResponseEntity<ProductBean> entity = ResponseEntity.created(uri).body(insert);
//			return entity;
//		} else {
//			ResponseEntity<?> entity = ResponseEntity.noContent().build();
//			return entity;
//		}
//	}
//
//	@DeleteMapping("/products/{id}")
//	public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
////		成功：204 (No Content)、message body空白(不包含已經刪除的resource資料)
////		失敗(resource不存在)：404 (Not Found)
//
//		ProductBean bean = new ProductBean();
//		bean.setId(id);
//
//		boolean delete = productReositoryService.delete(bean);
//		if(delete) {
//			ResponseEntity<?> entity = ResponseEntity.noContent().build();
//			return entity;
//		} else {
//			ResponseEntity<?> entity = ResponseEntity.notFound().build();
//			return entity;
//		}
//	}
//
//	@PutMapping("/products/{id}")
//	public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody String body) {
////		修改(整體替換)：PUT message body包含需要修改(替換)的resource資料
////		成功(resource存在、替換成功)：200 (OK)、message body包含修改(整體替換)過的resource資料
////		失敗(resource不存在、不新增resource)：404 (Not Found)
//
//		JSONObject jsonObj = new JSONObject(body);
//		Date date = null;
//		try {
//			String make = jsonObj.getString("make");
//			date = new SimpleDateFormat("yyyy-MM-dd").parse(make);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		ProductBean bean = new ProductBean();
//		bean.setId(id);
//		bean.setName(jsonObj.getString("name"));
//		bean.setPrice(jsonObj.getDouble("price"));
//		bean.setMake(date);
//		bean.setExpire(jsonObj.getInt("expire"));
//
//		ProductBean update = productReositoryService.update(bean);
//		if(update!=null) {
//			ResponseEntity<ProductBean> entity = ResponseEntity.ok().body(update);
//			return entity;
//		} else {
//			ResponseEntity<?> entity = ResponseEntity.notFound().build();
//			return entity;
//		}
//	}
}
