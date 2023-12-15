# 프로젝트: DreamAir


## 목차


## 주제

## 프로젝트 배경


### 팀 구성
- 인원 : 4명
- 한현진(팀장)
  - 주요 담당 : 게시판
  - 프로젝트 설계 및 DB 구축, 게시판 목록/등록/수정/삭제, 버스 예매 시스템, 디자인 구성
- 이유나(팀원)
  - 주요 담당 : 사용자
  - 프로젝트 설계 및 DB 구축, 회원가입/수정/탈퇴, 탑승권 조회/좌석 변경/환불, 실시간 좌석 선택 기능 구현
- 임성민(팀원)
  - 주요 담당 : 항공권 구매
  - 프로젝트 설계 및 DB 구축, 항공권 조회/예매/결제, 탑승객 정보 관리, 결제 API 연동
- 정슬기(팀원)
  - 주요 담당 : 관리자
  - 프로젝트 설계 및 DB 구축, 상품/사용자/예매/탑승권 관리 ,스프링 시큐리티 적용, 레이아웃 구성
 

## 프로젝트 기간
- 2023-10-27 ~ 2023-11-15


## 개발 환경
- 사용 언어 ajax
  + <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"/> <img src="https://img.shields.io/badge/html-E34F26?style=flat&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=flat&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/jquery-0769AD?style=flat&logo=jquery&logoColor=white">
- 프레임워크
  + <img src="https://img.shields.io/badge/bootstrap-7952B3?style=flat&logo=bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/springboot 2-6DB33F?style=flat&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/springsecurity 5-6DB33F?style=flat&logo=springsecurity&logoColor=white"> <img src="https://img.shields.io/badge/MyBatis 3-6DB33F?style=flat&logo=MyBatis&logoColor=white"> <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white">
- 개발도구 jdk11?
  + <img src="https://img.shields.io/badge/openjdk:17.0.4.1-686767?style=flat&logo=openjdk&logoColor=black"/> <img src="https://img.shields.io/badge/visualstudiocode:1.74.1-007ACC?style=flat&logo=visualstudiocode&logoColor=white"/> <img src="https://img.shields.io/badge/mysql:8.0.31-4479A1?style=flat&logo=mysql&logoColor=white"/>
- 라이브러리
  + <img src="https://img.shields.io/badge/Lombok-6DB33F?style=flat&logo=Lombok&logoColor=white"> <img src="https://img.shields.io/badge/Devtools-6DB33F?style=flat&logo=springboot&logoColor=white">
- 사용 DB : <img src="https://img.shields.io/badge/mysql:8.0.31-4479A1?style=flat&logo=mysql&logoColor=white"/> 
- 참조 API : qr, 결제
- 협업 Tools : <img src="https://img.shields.io/badge/trello-0052CC?style=flat&logo=trello&logoColor=white"/> <img src="https://img.shields.io/badge/github-181717?style=flat&logo=github&logoColor=white"/>


## 요구사항 정의서


## ERD



## 주요 기능
- 게시판
- 소셜 회원가입(카카오)
- 관리자 페이지


## 프로젝트 리뷰

<details>
<summary><h3>메인 화면 👆</h3></summary>
<div markdown="1">


</div>
</details>

\***

<details>
<summary><h3>회원가입 👆</h3></summary>
<div markdown="1">


</div>
</details>

\***

<details>
<summary><h3>프로필 👆</h3></summary>
<div markdown="1">


</div>
</details>

\***

<details>
<summary><h3>로그인 👆</h3></summary>
<div markdown="1">


</div>
</details>

\***

<details>
<summary><h3>아이디 / 비밀번호 찾기 👆</h3></summary>
<div markdown="1">


</div>
</details>

\***

<details>
<summary><h3>커뮤니티 👆</h3></summary>
<div markdown="1">

</div>
</details>

\***

<details>
<summary><h3>관리자 👆</h3></summary>
<div markdown="1">

</div>
</details>

\***


## 한계
- 같은 이메일의 일반회원 & 소셜회원일 경우 동일 session 부여를 통해 같은 ID로 처리하고자 했으나 Access Token과 같은 추가정보를 불러오는 데 어려움을 겪어 실패하였음
- 회원 탈퇴 시 작성했던 댓글에 대한 처리가 원활하지 못함


## 참조
- 카카오 로그인 document: https://developers.kakao.com/docs/latest/ko/kakaologin/common
- Last.fm API: https://www.last.fm/api
- Youtube API: https://developers.google.com/youtube/v3/getting-started?hl=ko


## 변경점
\***
2023-03-24, 기본 UI 구현

2023-03-27, MySQL, MongoDB 연동

2023-03-28, Lastfm API 연결, 차트 페이지

2023-04-03, 배포
\***
