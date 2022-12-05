# Blog Project 
> 블로그 프로젝트

![메인](https://user-images.githubusercontent.com/104826026/205257592-bf701844-63b6-447d-84cc-9a0c2296418f.png)


## 목차
* 개요
  * 프로젝트 소개
  * 사용 기술

* 요구사항 분석
  * 회원가입
  * 로그인
  * 회원 정보 수정
  * 게시판
  * 댓글
  
* DB 설계

* 구현

* 개발 내용

---
## 개요
### 1. 프로젝트 소개
* 프로젝트 명: 스프링부트를 이용한 블로그 프로젝트
* 개발 인원: 1명
* 개발 기간: 2022.11.10 ~ 2022.11.30

### 2. 사용 기술
* 백엔드
  * java 8.0
  * SpringBoot
  * STS4
  * JPA

* 프론트엔드
  * HTML/CSS
  * JavaScript
  * Ajax
  * BootStrap
 
* DB
  * MySQL
---
## 요구사항 분석
### 1. 회원가입, 로그인, 회원정보수정
* Spring Security 사용
* 비밀번호 해쉬화
* 회원가입시 유효성 검사 및 중복 검사
* 로그인시에만 게시판 접근 가능

### 2. 게시판
* CRUD, 조회수, 페이징 기능 구현
* 게시글 작성자만 수정 및 삭제 가능

### 3. 댓글
* 댓글 작성, 삭제 기능 구현
* 댓글 작성자만 삭제 가능
---
## DB 설계
![erd](https://user-images.githubusercontent.com/104826026/205219395-f4adda79-6a83-43af-b05f-743a9e6a2657.PNG)

---
## 구현
### 1. 실행 화면
<details>
<summary>회원가입, 로그인</summary>
<div markdown="1">
<br>
<p>1. 유효성 및 아이디 중복 검사</p>
<img src="https://user-images.githubusercontent.com/104826026/205252112-56445b62-ebd2-4672-8aa8-c65ce6a7cde0.PNG"></img>

<br>
<p>2. 회원가입 완료</p>
<img src="https://user-images.githubusercontent.com/104826026/205250306-8f040f00-679b-4c67-9a03-e835ada5a0fd.PNG"></img>

<br>
<p>3. 로그인 실패</p>
<img src="https://user-images.githubusercontent.com/104826026/205253265-ffa094b1-d262-4b14-b126-8a9706d2cbf4.gif"></img>

</div>
</details>

<details>
<summary>게시판, 댓글</summary>
<div markdown="1">

<br>
<p>1. 게시글 작성</p>
<img src="https://user-images.githubusercontent.com/104826026/205254244-b16389ff-929f-4202-9593-390b24db6194.PNG"></img>

<br>
<p>2. 게시글 목록, 페이징</p>
<img src="https://user-images.githubusercontent.com/104826026/205254352-fd602c1b-c1fb-43ec-8ed7-1de472f18084.PNG"></img>

<br>
<p>3. 게시글 보기</p>
<img src="https://user-images.githubusercontent.com/104826026/205254408-b829a7db-35ea-437f-bf5c-5efa44e7e223.PNG"></img>

<br>
<p>4. 댓글</p>
<img src="https://user-images.githubusercontent.com/104826026/205254456-1a9109b6-9fb0-44f0-a3f4-7aacfe188098.PNG"></img>
</div>
</details>

---
## 개발 내용
[0. 전체](https://dot-agate-dab.notion.site/9765f75bf2074a6abbff55f0bdb9e168) <br>
[1. 프로젝트 생성](https://dot-agate-dab.notion.site/1-9c66838505214e1ca177c6c257e6a00a) <br>
[2. 테이블](https://dot-agate-dab.notion.site/2-Entity-88c78b2dfeac4a5aa41b9575eff28f63) <br>
[3. 회원가입](https://dot-agate-dab.notion.site/3-a906704bedb74ced92fc95a7c48d06a7) <br>
[4. 스프링 시큐리티 ](https://dot-agate-dab.notion.site/4-c3737ad8b9564f58920ed7ea88c9e544) <br>
[5. 유효성 검사](https://dot-agate-dab.notion.site/5-deac1aee96424159bc18d0dd1cd3b2e9) <br>
[6. 아이디 중복 확인](https://dot-agate-dab.notion.site/6-f527bda10d0e42279277c0759b6330d4) <br>
[7. 로그인 실패 처리](https://dot-agate-dab.notion.site/7-f71df0e90da14310ae87bc65af0d90e6) <br>
[8. 회원 정보 수정](https://dot-agate-dab.notion.site/8-ca8451ec43e745be85af0a5131793999) <br>
[9. 게시글 작성](https://dot-agate-dab.notion.site/9-ad6966d773814f93b61ebdd9918586c6) <br>
[10. 글 목록, 페이징](https://dot-agate-dab.notion.site/10-d9482e3d71584767b5693668bac722c3) <br>
[11. 글 내용 보기, 조회수](https://dot-agate-dab.notion.site/11-87e25bb49ca24413b155d59fef9ec107) <br>
[12. 글 수정하기](https://dot-agate-dab.notion.site/12-773c92d3abc94b31a34b9aea4cdb1c4e) <br>
[13. 글 삭제하기](https://dot-agate-dab.notion.site/13-3f6955ac80474a13848d24a4e79addf0) <br>
[14. 댓글 달기](https://dot-agate-dab.notion.site/14-75d4197ac9714d83a4d843e33f32bcb6) <br>
[15. 댓글 삭제](https://dot-agate-dab.notion.site/15-3d689e8fdd6941d6973f28f981ca568e) <br>

---
## 프로젝트 보완 및 추가 예정 기능
<details>
<summary>보완</summary>
<div markdown="1">
 <p>회원 정보 수정시 비밀번호 수정하거나 원래 비밀번호를 입력하지 않고 이메일이나 이름만 수정할 시 비밀번호를 수정하지 않았음에도 로그인이 안되는 에러가 발생하여 회정 정보를 수정할 때는 무조건 비밀번호를 변경하거나 기존 비밀번호를 입력해야 로그인이 가능하여 해당 부분을 수정할 예정</p>
</div>
</details>

<details>
<summary>추가 기능</summary>
<div markdown="1">
 <p>카카오/네이버 로그인</p><br>
 <p>관리자 페이지</p><br>
 <p>검색 기능</p><br>
 <p>AWS 엘라스틱 빈스톡을 이용한 호스팅(진행중)</p><br>
</div>
</details>







