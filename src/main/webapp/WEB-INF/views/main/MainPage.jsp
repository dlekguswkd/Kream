<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>SHOP | KREAM</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/MainPage.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css" />
  
   	<!-- Axios 라이브러리 포함 -->
	<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  
  </head>

  <body>
    <div class="layout_main_container">
      <div class="menu_container">
        <div class="shop_name">
        
        <!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		
          <h1 class="shop_title">SHOP</h1>
        </div>
      </div>

      <div class="popular_shoes">
        <div class="popular_shoes_list_container" id="shoeList">
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Nike Air Zoom Pegasus 36"
            />
            <div class="popular_item_name">Nike Air Zoom Pegasus 36</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Adidas Ultraboost 20"
            />
            <div class="popular_item_name">Adidas Ultraboost 20</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="Puma Zoom V2" />
            <div class="popular_item_name">Puma Zoom V2</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Converse All Star"
            />
            <div class="popular_item_name">Converse All Star</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="Reebok Classic 3" />
            <div class="popular_item_name">Reebok Classic 3</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="New Balance 820" />
            <div class="popular_item_name">New Balance 820</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Asics Gel-Nimbus 20</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Nike Air Zoom Pegasus 36"
            />
            <div class="popular_item_name">Nike Air Zoom Pegasus 36</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Adidas Ultraboost 20"
            />
            <div class="popular_item_name">Adidas Ultraboost 20</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="Puma Zoom V2" />
            <div class="popular_item_name">Puma Zoom V2</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Converse All Star"
            />
            <div class="popular_item_name">Converse All Star</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="Reebok Classic 3" />
            <div class="popular_item_name">Reebok Classic 3</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="New Balance 820" />
            <div class="popular_item_name">New Balance 820</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Asics Gel-Nimbus 20</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Nike Air Zoom Pegasus 36"
            />
            <div class="popular_item_name">Nike Air Zoom Pegasus 36</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Adidas Ultraboost 20"
            />
            <div class="popular_item_name">Adidas Ultraboost 20</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="Puma Zoom V2" />
            <div class="popular_item_name">Puma Zoom V2</div>
          </a>
          <a href="#" class="popular_item">
            <img
              src="https://via.placeholder.com/150"
              alt="Converse All Star"
            />
            <div class="popular_item_name">Converse All Star</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="Reebok Classic 3" />
            <div class="popular_item_name">Reebok Classic 3</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="New Balance 820" />
            <div class="popular_item_name">New Balance 820</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Asics Gel-Nimbus 20</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
          <a href="#" class="popular_item">
            <img src="https://via.placeholder.com/150" alt="shoes" />
            <div class="popular_item_name">Skechers Classic 2</div>
          </a>
        </div>
      </div>

      <div class="sidebar">
        <div class="sidebar_container">
          <div class="filter-section">
            <h2>필터</h2>
          </div>
          <h4>브랜드</h4>
          <c:forEach items="${requestScope.brandList}" var="MainVo">
	          <div class="filter-section">
	            <ul>
	              <li><input type="checkbox" />${MainVo.brandName}</li>
	            </ul>
	          </div>
          </c:forEach>
          <!-- 	  <li><input type="checkbox" /> 032c</li>
	              <li><input type="checkbox" /> 1017 Alyx 9SM</li>
	              <li><input type="checkbox" /> Adidas</li>
	              <li><input type="checkbox" /> & Other Stories</li>
	              <li><input type="checkbox" /> 032c</li>
	              <li><input type="checkbox" /> 1017 Alyx 9SM</li>
	              <li><input type="checkbox" /> Adidas</li>
	              <li><input type="checkbox" /> & Other Stories</li>
	              <li><input type="checkbox" /> 032c</li>
	              <li><input type="checkbox" /> 1017 Alyx 9SM</li>
	              <li><input type="checkbox" /> Adidas</li> -->

          <h4>사이즈</h4>
          <div class="filter-section">
            <div class="size-grid">
              <button>230</button>
              <button>235</button>
              <button>240</button>
              <button>245</button>
              <button>250</button>
              <button>255</button>
              <button>260</button>
              <button>265</button>
              <button>270</button>
              <button>275</button>
              <button>280</button>
            </div>
          </div>

          <h4>색상</h4>
          <div class="filter-section">
            <div class="color-grid">
              <div>
                <button class="color-circle black"></button>
                <p>Black</p>
              </div>
              <div>
                <button class="color-circle white"></button>
                <p>White</p>
              </div>
              <div>
                <button class="color-circle gray"></button>
                <p>Gray</p>
              </div>
              <div>
                <button class="color-circle red"></button>
                <p>Red</p>
              </div>
              <div>
                <button class="color-circle blue"></button>
                <p>Blue</p>
              </div>
              <div>
                <button class="color-circle green"></button>
                <p>Green</p>
              </div>
              <div>
                <button class="color-circle yellow"></button>
                <p>Yellow</p>
              </div>
              <div>
                <button class="color-circle orange"></button>
                <p>Orange</p>
              </div>
              <div>
                <button class="color-circle purple"></button>
                <p>Purple</p>
              </div>
              <div>
                <button class="color-circle pink"></button>
                <p>Pink</p>
              </div>
              <div>
                <button class="color-circle brown"></button>
                <p>Brown</p>
              </div>
              <div>
                <button class="color-circle navy"></button>
                <p>Navy</p>
              </div>
              <div>
                <button class="color-circle magenta"></button>
                <p>Magenta</p>
              </div>
              <div>
                <button class="color-circle lightblue"></button>
                <p>Light Blue</p>
              </div>
              <div>
                <button class="color-circle cerulean"></button>
                <p>Cerulean</p>
              </div>
              <div>
                <button class="color-circle mint"></button>
                <p>Mint</p>
              </div>
              <div>
                <button class="color-circle darkblue"></button>
                <p>Dark Blue</p>
              </div>
              <div>
                <button class="color-circle darkgreen"></button>
                <p>Dark Green</p>
              </div>
            </div>
          </div>

          <div>
            <button class="filter-button" type="">필터</button>
          </div>


        </div>
      </div>

      <div class="products_container">
      
      	<c:forEach items="${requestScope.mainList}" var="MainVo">
	        <div class="products">
	          <a href="${pageContext.request.contextPath}/detailform?prodNo=${sessionScope.prod.prodNo}" class="products_selling_items">
	            <img src="${pageContext.request.contextPath}/upload/${MainVo.saveName}" alt="shoes" />
	            <div class="products_selling_items_name">
	              ${MainVo.engName}
	            </div>
	            <div class="products_selling_items_price">${MainVo.prodPrice}</div>
	          </a>
	         </div>
         </c:forEach>
          
      <!--     <a href="#" class="products_selling_items">
            <img src="https://via.placeholder.com/300" alt="shoes" />
            <div class="products_selling_items_name">
              Nike Air Zoom Pegasus 36
            </div>
            <div class="products_selling_items_price">$150</div>
          </a>
          <a href="#" class="products_selling_items">
            <img src="https://via.placeholder.com/300" alt="shoes" />
            <div class="products_selling_items_name">
              Nike Air Zoom Pegasus 36
            </div>
            <div class="products_selling_items_price">$150</div>
          </a>

           -->
          
        
        <div id="paging" class="clearfix">
          <div id="nums" class="clearfix">
              <ul>
                  <li><a href="">◀</a></li>
                  <li><a href="">1</a></li>
                  <li><a href="">2</a></li>
                  <li><a href="">3</a></li>
                  <li><a href="">4</a></li>
                  <li><a href="">5</a></li>
                  <li><a href="">6</a></li>
                  <li><a href="">7</a></li>
                  <li><a href="">8</a></li>
                  <li><a href="">9</a></li>
                  <li><a href="">10</a></li>
                  <li><a href="">▶</a></li>
              </ul>
          </div>
      </div>
      </div>
    </div>


    	<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

  </body>
</html>
