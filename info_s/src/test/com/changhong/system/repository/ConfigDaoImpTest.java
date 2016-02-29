package com.changhong.system.repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.changhong.common.utils.CHStringUtils;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Jack Wang
 * Date: 14-11-20
 * Time: 上午8:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/database.xml", "/applicationContext.xml"})
public class ConfigDaoImpTest extends TestCase {

    @Resource
    ConfigDao configDao;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSingle() {
        configDao.updateConfiguration("MO_DB_HOST", "192.168.01.135");
    }

    @Test
    public void testLoadJson() {
        //解析数据
        String deviceFile = "D:\\ChangHong\\SCN_Column.json";
        StringBuilder builder = new StringBuilder();

        File file = new File(deviceFile);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line = "";
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String json = builder.toString().replace(" ", "");
        System.out.println(json);

        //组装数据
        JSONObject o = JSONObject.parseObject(json);
        System.out.println(1);

        List<Category> categories = new ArrayList<Category>();

        JSONArray nodes = o.getJSONObject("result").getJSONArray("NodeInfo");
        for (Object loop : nodes) {
            JSONObject node = (JSONObject) loop;
            int id = node.getIntValue("id");
            String name = node.getString("name");
            String description = node.getString("description");

            Category category = new Category(id, name, description);
            categories.add(category);

            JSONArray subNodes = node.getJSONArray("ListOfEntry");
            for (Object subLoop : subNodes) {
                JSONObject subNode = (JSONObject) subLoop;

                int subId = subNode.getIntValue("id");
                String subName = subNode.getString("name");
                String subDescription = subNode.getString("description");

                SubCategory subCategory = new SubCategory(subId, subName, subDescription);
                category.addSubCategory(subCategory);

                for (int i = 1; i <= 10; i++) {
                    Movie movie = new Movie(i, category.getId(), subCategory.getId());
                    subCategory.addMovie(movie);
                }
            }
        }

        //打印数据
        for (Category category : categories) {
            System.out.println("一级分类：" + category.getName());

            for (SubCategory subCategory : category.getSubCategories()) {
                System.out.println("二级分类：" + subCategory.getName());

                System.out.println(CHStringUtils.toFixNumberString("LOGO", 30) + CHStringUtils.toFixNumberString("SOURCE", 30) + CHStringUtils.toFixNumberString("NAME", 30));
                for (Movie movie : subCategory.getMovies()) {
                    System.out.println(CHStringUtils.toFixNumberString(movie.getLogo(), 30) + CHStringUtils.toFixNumberString(movie.getSource(), 30) + CHStringUtils.toFixNumberString(movie.getName(), 30));
                }
            }

            System.out.println("------------------------------------------");
        }

        //重组JSON
        JSONObject all = new JSONObject();
        JSONArray categoryArray = new JSONArray();
        all.put("category", categoryArray);

        for (Category category : categories) {
            JSONObject categoryObject = new JSONObject();
            categoryArray.add(categoryObject);

            categoryObject.put("id", category.getId());
            categoryObject.put("name", category.getName());
            categoryObject.put("description", category.getDescription());

            JSONArray subCategoryArray = new JSONArray();
            categoryObject.put("subCategory", subCategoryArray);

            for (SubCategory subCategory : category.getSubCategories()) {
                JSONObject subCategoryObject = new JSONObject();
                subCategoryArray.add(subCategoryObject);

                subCategoryObject.put("id", subCategory.getId());
                subCategoryObject.put("name", subCategory.getName());
                subCategoryObject.put("description", subCategory.getDescription());

                JSONArray movieArray = new JSONArray();
                subCategoryObject.put("movies", movieArray);

                for (Movie movie : subCategory.getMovies()) {
                    JSONObject movieObject = new JSONObject();
                    movieArray.add(movieObject);

                    movieObject.put("logo", movie.getLogo());
                    movieObject.put("source", movie.getSource());
                    movieObject.put("name", movie.getName());
                }
            }
        }

        System.out.println(all.toString());
    }

}
