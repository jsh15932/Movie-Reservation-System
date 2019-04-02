<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <%@ include file="./viewFragment/header.jspf" %>
  <body>
    <div class="container-fluid">
      <div class="row d-flex d-md-block flex-nowrap wrapper">
        <%@ include file="./viewFragment/navigation.jspf" %>
        <main id="main" class="col-md-9 float-left col pl-md-5 pt-3 main">
          <div class="page-header mt-3">
            <h2>공지사항</h2>
          </div>
          <p class="lead">공지사항의 내용을 추가/수정하거나 삭제할 수 있습니다.</p>
          <section class="mt-4 mb-3 pt-4 pb-3" style="max-width:1080px;">
            <hr>
            <table class="table table-striped">
              <thead>
                <tr>
                  <th class="mobile" style="width:55px; text-align:center;">번호</th>
                  <th style="text-align:center;">제목</th>
                  <th class="mobile" style="width:80px; text-align:center;">작성자</th>
                  <th class="mobile" style="width:120px; text-align:center;">날짜</th>
                  <th class="mobile" style="width:120px; text-align:center;">수정/삭제</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td style="text-align: center;">3</td>
                  <td>신규 운영진을 모집합니다.</td>
                  <td style="text-align: center;">운영자</td>
                  <td style="text-align: center;">2018-01-05</td>
                  <td onclick="location.href = './noticeEditView.reservation';" class="btn btn-primary">수정</td>
                <td onclick="location.href = './noticeDeleteView.reservation';" class="btn btn-primary">삭제</td>
                </tr>
                <tr>
                  <td style="text-align: center;">2</td>
                  <td>커뮤니티 웹 사이트에 오신 것을 환영합니다.</td>
                  <td style="text-align: center;">운영자</td>
                  <td style="text-align: center;">2018-01-04</td>
                  <td onclick="location.href = './noticeEditView.reservation';" class="btn btn-primary">수정</td>
                <td onclick="location.href = './noticeDeleteView.reservation';" class="btn btn-primary">삭제</td>
                </tr>
                <tr>
                  <td style="text-align: center;">1</td>
                  <td>커뮤니티 웹 사이트가 개설되었습니다.</td>
                  <td style="text-align: center;">운영자</td>
                  <td style="text-align: center;">2018-01-03</td>
                  <td onclick="location.href = './noticeEditView.reservation';" class="btn btn-primary">수정</td>
                <td onclick="location.href = './noticeDeleteView.reservation';" class="btn btn-primary">삭제</td>
                </tr>
              </tbody>
            </table>
               <div style="max-width:1080px;">
            <a href="./boardWriteView.reservation" class="btn btn-primary float-right">글쓰기</a>
          </div>
          <ul class="pagination">
            <li class="page-item disabled">
              <span class="page-link">&laquo;</span>
            </li>
            <li class="page-item active"><a class="page-link mobile" href="#">1</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">2</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">3</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">4</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">5</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">6</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">7</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">8</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">9</a></li>
            <li class="page-item"><a class="page-link mobile" href="#">10</a></li>
            <li class="page-item">
              <span class="page-link">&raquo;</span>
            </li>
          </ul>
       </div>
    </div>
    </section>
    </main>
      </div>
    </div>
    <%@ include file="./viewFragment/footer.jspf" %>
    <%@ include file="./viewFragment/modal.jspf" %>
  </body>
</html>