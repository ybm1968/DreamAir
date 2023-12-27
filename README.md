# 프로젝트: DreamAir
<p align="center"><img src="https://github.com/ybm1968/DreamAir/assets/132187402/2ec7629c-e5f7-4b0f-9c09-16b8ef20024b" style="" width="800" height="400"/></p>

[시연영상](https://youtu.be/-0-vmoaVhgA?si=4chZW3p9m6Yd5Yw5)

 
## 목차
### 1. 프로젝트 개요
  - 프로젝트 주제
  - 주제 선정 배경
  - 기획 의도
  - 활용방안 및 기대효과
### 2. 프로젝트 구조
  - 주요 기능
  - Menu Structure
  - Flow Chart
### 3. 프로젝트 팀 구성 및 역할
### 4. 프로젝트 수행절차 및 방법
  - 수행 절차
  - 수행 방법
### 5. 프로젝트 수행 경과
  - 요구사항 정의서
  - 기능 정의서
  - ERD
  - 테이블 정의서
  - 화면 설계서
  - 프로젝트 실제 화면 UI
### 6. 핵심기능 코드 리뷰
  - 기능 목표
  - QR코드 생성 및 처리과정
  - 개선 할 점

### 7. 자체 평가 의견
  - 개별 평가
  - 종합 평가

# 1. 프로젝트 개요
## 1-1. 프로젝트 주제
- 사용자 경험을 공유하고 항공권 구매가 가능한 여행 포털사이트 구축 프로젝트


## 1-2. 주제 선정 배경
<img src="https://github.com/ybm1968/DreamAir/assets/132187402/6d8b2073-83e3-4044-822f-ffe4e47f3f18" width="800" height="500"/>
<img src="https://github.com/ybm1968/DreamAir/assets/132187402/b8274ccf-506c-4085-9044-00309235ab4c" width="800" height="500"/>
<img src="https://github.com/ybm1968/DreamAir/assets/132187402/31a1b706-0bbb-40e5-9348-bab3251793c8" width="800" height="500"/>
<img src="https://github.com/ybm1968/DreamAir/assets/132187402/328617e6-0ac3-42cb-bb8a-e6846b87e18d" width="800" height="500"/>


## 1-3. 기획의도
### 기존 저가 항공사(LCC, Low Cost Carrier)의 문제점을 고려하여, 저렴한 항공권을 제공하지만 서비스 부문에서 체계적이고 다양하게 제공함으로써 사용자가 여행을 더 긍정적으로 경험하고 즐길 수 있도록 함
- 저가 항공사의 문제점 개선 : 합리적인 가격과 더불어 체계적인 서비스 제공
- 실시간 좌석 선택 : 사용자가 실시간으로 좌석 현황을 볼 수 있어 원하는 자리를 선점 할 수 있음 
- 사용자 편리성 제공 : QR 코드 탑승권 발행
- 풍요로운 여행 서비스 제공 : 출발지/도착지에 대한 날씨와 각 도시 관광 정보, 여행 가이드 제공

## 1-4. 활용 방안 및 기대효과
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B0%9C%EC%9A%94/%ED%99%9C%EC%9A%A9%EB%B0%A9%EC%95%88%EB%B0%8F%EA%B8%B0%EB%8C%80%ED%9A%A8%EA%B3%BC.PNG" width="800" height="500"/>

# 2. 프로젝트 구조
## 2-1. 주요기능
- 사용자
  - 회원가입
  - 로그인/로그아웃
  - 마이페이지 
- 관리자
  - 로그인/로그아웃
  - 관리자 관리
  - 사용자 관리
  - 항공기/상품관리
  - 예매관리
  - 탑승권 관리 
- 에매 서비스
  - 항공권 조회/예매/결제
  - 공항 버스 조회/예매/결제
  - 탑승권 번호 및 QR코드 발행 
- 게시판
  - 사용자 여행 경험공유
  - 여행 정보 제공
  - 프로모션 정보 제공

## 2-2. Menu Structure
<details>
<summary><h3>Menu Structure 👆</h3></summary>
<div markdown="1">

<img src="https://github.com/ybm1968/DreamAir/assets/132187402/dafcbfb4-3ca5-49f6-b6e4-686476483415" width="900" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/assets/132187402/c4738c3d-e8bf-4d28-b9f1-02808a2c6615" width="900" height="600"/>

</div>
</details>

## 2-3. Flow Chart
<details>
<summary><h3>Flow Chart 👆</h3></summary>
<div markdown="1">

<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B5%AC%EC%A1%B0/image129.png" width="900" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B5%AC%EC%A1%B0/image123.png" width="900" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B5%AC%EC%A1%B0/image116.png" width="900" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B5%AC%EC%A1%B0/image117.png" width="900" height="600"/>

</div>
</details>


# 3.프로젝트 팀 구성 및 역할
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
 
# 4. 프로젝트 수행절차 및 방법
## 4-1. 프로젝트 수행 절차
- 2023-10-27 ~ 2023-11-15
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B0%9C%EC%9A%94/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%20%EA%B8%B0%EA%B0%84.png" width="900" height="500"/>


## 4-2. 수행 방법
- 사용 언어 
  + <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"/> <img src="https://img.shields.io/badge/html-E34F26?style=flat&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=flat&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat&logo=javascript&logoColor=black"> <img src="https://img.shields.io/badge/jquery-0769AD?style=flat&logo=jquery&logoColor=white0"> <img src="https://img.shields.io/badge/Ajax-007396?style=flat&logo=Ajax&logoColor=white">
- 프레임워크
  + <img src="https://img.shields.io/badge/bootstrap-7952B3?style=flat&logo=bootstrap&logoColor=white"> <img src="https://img.shields.io/badge/springboot 2.7.18-6DB33F?style=flat&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/springsecurity-6DB33F?style=flat&logo=springsecurity&logoColor=white"> <img src="https://img.shields.io/badge/MyBatis-6DB33F?style=flat&logo=MyBatis&logoColor=white"> <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=flat&logo=thymeleaf&logoColor=white">
- 개발도구 
  + <img src="https://img.shields.io/badge/openjdk:1.8-686767?style=flat&logo=openjdk&logoColor=black"/> <img src="https://img.shields.io/badge/visualstudiocode-007ACC?style=flat&logo=visualstudiocode&logoColor=white"/> <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"/>
- 라이브러리
  + <img src="https://img.shields.io/badge/Lombok-6DB33F?style=flat&logo=Lombok&logoColor=white"> <img src="https://img.shields.io/badge/Devtools-6DB33F?style=flat&logo=springboot&logoColor=white">
- 사용 DB : <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"/> 
- 참조 API : <img src="https://img.shields.io/badge/Iamport-007396?style=flat&logo=Iamport&logoColor=white"> <img src="https://img.shields.io/badge/Zxing-007396?style=flat&logo=Zxing&logoColor=white">
- 협업 Tools : <img src="https://img.shields.io/badge/trello-0052CC?style=flat&logo=trello&logoColor=white"/> <img src="https://img.shields.io/badge/github-181717?style=flat&logo=github&logoColor=white"/> <img src="https://img.shields.io/badge/GoogleDrive-4285F4?style=flat&logo=GoogleDrive&logoColor=white"/>

# 5. 프로젝트 수행 경과
## 5-1. 요구사항 정의서
<details>
<summary><h3>요구사항 정의서 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EC%A0%95%EC%9D%98%EC%84%9C/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%EC%A0%95%EC%9D%98%EC%84%9C1.PNG" width="1000" height="700"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EC%A0%95%EC%9D%98%EC%84%9C/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%EC%A0%95%EC%9D%98%EC%84%9C2.PNG" width="1000" height="700"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%20%EC%A0%95%EC%9D%98%EC%84%9C/%EC%9A%94%EA%B5%AC%EC%82%AC%ED%95%AD%EC%A0%95%EC%9D%98%EC%84%9C3.PNG" width="1000" height="600"/>

</div>
</details>

## 5-2. 기능 정의서
<details>
<summary><h3>기능 정의서 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/assets/132187402/3b2071d0-13d4-4481-98fd-307c224d6272" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C2.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C3.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C4.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C5.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C6.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C/%EA%B8%B0%EB%8A%A5%EC%A0%95%EC%9D%98%EC%84%9C7.PNG" width="1000" height="600"/>
  
</div>
</details>

## 5-3. ERD
<details>
<summary><h3>ERD 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/ERD/%ED%95%AD%EA%B3%B5%EA%B6%8C%20%EC%98%88%EB%A7%A4%20(1).png" width="1000" height="800"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/ERD/erd4.PNG" width="1000" height="700"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/ERD/erd5.PNG" width="1000" height="700"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/ERD/erd2.PNG" width="1000" height="700"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/ERD/erd3.PNG" width="1000" height="700"/>

</div>
</details>

## 5-4. 테이블 정의서
<details>
<summary><h3>테이블 정의서 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C1.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C2.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C3.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C4.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C5.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C6.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C7.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C8.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C9.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C10.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C/%ED%85%8C%EC%9D%B4%EB%B8%94%EC%A0%95%EC%9D%98%EC%84%9C11.PNG" width="1000" height="600"/>

</div>
</details>

## 5-5. 화면 설계서
<details>
<summary><h3>사용자 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%801.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%802.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%803.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%804.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%805.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%806.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%807.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%808.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%809.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8010.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8011.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8012.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8013.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8014.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8015.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8016.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8017.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8018.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%9C%A0%EC%A0%8019.png" width="1000" height="600"/>



</div>
</details>

----

<details>
<summary><h3>관리자 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%901.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%902.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%903.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%904.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%905.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%906.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%907.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%908.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%909.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%9010.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%9011.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%9012.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%9013.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%9014.png" width="1000" height="600"/>

</div>
</details>

----

<details>
<summary><h3>예매 서비스 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A41.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A42.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A43.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A44.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A45.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A46.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A47.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A48.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A49.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A410.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A41.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A42.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A43.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A44.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A45.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A46.png" width="1000" height="600"/>

</div>
</details>

----

<details>
<summary><h3>게시판 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%901.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%902.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%903.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%904.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%905.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%99%80%EC%9D%B4%EC%96%B4%20%ED%94%84%EB%A0%88%EC%9E%84/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%906.png" width="1000" height="600"/>

</div>
</details>


----


## 5-6. 프로젝트 실제 화면 UI

<details>
<summary><h3>사용자 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%901.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%902.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%903.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%904.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%905.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%906.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%82%AC%EC%9A%A9%EC%9E%90/%EC%82%AC%EC%9A%A9%EC%9E%907.png" width="1000" height="600"/>

</div>
</details>

----

<details>
<summary><h3>관리자 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%901.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%902.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%903.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%904.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%905.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%906.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%907.png" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B4%80%EB%A6%AC%EC%9E%90/%EA%B4%80%EB%A6%AC%EC%9E%908.PNG" width="1000" height="600"/>

</div>
</details>

----

<details>
<summary><h3>예매 서비스 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A41.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A42.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A43.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A44.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A45.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A46.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A47.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A48.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EC%98%88%EB%A7%A49.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EC%98%88%EB%A7%A4/%EB%B2%84%EC%8A%A41.PNG" width="1000" height="600"/>

</div>
</details>

----

<details>
<summary><h3>게시판 👆</h3></summary>
<div markdown="1">
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%901.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%902.PNG" width="1000" height="600"/>
<img src="https://github.com/ybm1968/DreamAir/blob/LSM/img/%EC%8B%A4%EC%A0%9C%ED%99%94%EB%A9%B4/%EA%B2%8C%EC%8B%9C%ED%8C%90/%EA%B2%8C%EC%8B%9C%ED%8C%903.png" width="1000" height="600"/>

</div>
</details>


----


# 6. 핵심기능 코드 리뷰
## 6-1. 기능목표
### 탑승권을 QR 코드의 형태로 제공하여 관리자가 편리하게 업무(사용자 탑승권 탑승 처리)를 볼 수 있도록 함
- 사용자의 종이 탑승권 분실 위험도 감소
- 탑승권 처리 시 해당 페이지로 자동 연결되므로 사용자 경험 개선
![캡처](https://github.com/ybm1968/DreamAir/assets/132187402/0361b8d7-2045-460a-a5b0-d1cc9f8d877b)


## 6-2. QR코드 생성 및 처리과정
### QR코드 생성 : 항공권 결제 완료 → 티켓 번호 발급 → QR 코드 생성
<details>
<summary><h3>QR코드 생성 👆</h3></summary>
<div markdown="1">


- QR 코드 등록을 위한 QRController.java 작성
  

```java
  // 등록
  @PostMapping()
    public ResponseEntity<?> create(@RequestBody QR qr) {
        log.info("[POST] - /qr - qr 등록");
        try {
            int result = qrService.insert(qr);
            if( result > 0 )
                return new ResponseEntity<>("qr 등록 완료", HttpStatus.CREATED);  // 201
            else
                return new ResponseEntity<>("qr 등록 실패", HttpStatus.OK);  

        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
```


- 항공권 결제 완료 시, QR 코드 등록을 위한 BookingServiceImple.java 작성

```java
// 탑승권 번호 발행 + QR 코드 발행
    @Override
    public int createTicket(Booking booking, Principal principal, HttpServletRequest request) throws Exception {
        String userId = "";
        int result = 0;
        int bookingNo = 0;
        int ticketNo = 0;
        int count1 = 0;
        int count2 = 0;
        HttpSession session = request.getSession();
        userId = (String) session.getAttribute("userId");

        // ✅ TODO : 조건 passeungerCount 에 따라서 티켓(탑승권 번호) 발행 
        for (int i = 0; i < booking.getPasCount(); i++) {
								...
            }

        // ✅ QR 코드 생성   
            QR qr = new QR();
            qr.setParentTable("booking");
            qr.setParentNo(ticketNo);
            String url = "http://localhost:" + serverPort + "/admin/Final_check?ticketNo=" + ticketNo;
            qr.setUrl( url );
            qr.setName("QR_" + ticketNo);

            qrService.makeQR(qr);

            result += count;
        }
        return result;
    }
```


- QR 코드 생성 시, [관리자 페이지 - QR 코드 목록]에서 확인 가능
![qr1](https://github.com/ybm1968/DreamAir/assets/132187402/bec5d1ec-16ab-42d3-ab92-e31d9d004240)


</div>
</details>

----

### QR코드 처리 : QR 코드 인식 →  탑승권 처리 페이지로 연결 → 해당 티켓 번호에 대한 탑승권 조회 → 탑승 처리 완료 → QR 코드 삭제
<details>
<summary><h3>QR코드 처리 👆</h3></summary>
<div markdown="1">


 
- QR 코드 삭제를 위한 QRController 작성
  
 
```java
// 삭제
    @DeleteMapping("/{qrNo}")
    public ResponseEntity<?> destroy(@PathVariable Integer qrNo) {
        log.info("[DELETE] - /qr/" + qrNo + " - qr 삭제");
        try {
            int result = qrService.delete(qrNo);
            if( result > 0 )
                return new ResponseEntity<>("qr 삭제 완료", HttpStatus.OK); 
            else
                return new ResponseEntity<>("qr 삭제 실패", HttpStatus.OK);
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
```


- 항공권 결제 완료 시, QR 코드 등록을 위한 BookingServiceImple.java 작성

```java
// 탑승권 화면 - 탑승 최종 확인 위한
    @GetMapping("/Final_check/{ticketNo}")
    public ResponseEntity<?> getOne(@PathVariable Integer ticketNo) {
        log.info("[GET] - /admin/Final_check" + ticketNo + "탑승권 조회");  
        try {
            List<Booking> pasTicketList = adminService.pas_ticketList(ticketNo);
            if( pasTicketList == null )
                log.info("탑승권 목록 없음");
            else
                log.info("탑승권 수 : " + pasTicketList.size());

                Files files = new Files();
                files.setParentTable("booking");
                files.setParentNo(ticketNo);
                List<Files> fileList = fileService.listByParent(files);

                QR qr = new QR();
                qr.setParentTable("booking");
                qr.setParentNo(ticketNo);
                List<QR> qrList = qrService.listByParent(qr);

                Map<String, Object> result = new HashMap<String,Object>();
                result.put("qrList", qrList);
                result.put("fileList", fileList);
                result.put("pasTicketList", pasTicketList);

            return new ResponseEntity<>(result, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
```


- QR 코드 인식 시, [관리자 페이지 - 탑승 처리]에서 탑승권 처리 가능
![qr2](https://github.com/ybm1968/DreamAir/assets/132187402/d9b34145-c9a5-48a1-8259-0bd11e7cd291)


</div>
</details>

----

## 6-3. 개선 할 점
- 추후 QR 코드를 사용자 버전과 관리자 버전으로 2개 생성하여 1) 사용자가 QR 코드를 인식 할 때 체크인 페이지로 이동하고, 2) 관리자가 QR 코드를 인식 할 때 탑승처리 페이지로 이동할 수 있도록 하여 보다 더 실제 항공사에서 사용하는 QR 코드 서비스처럼 구현하고자 함
  - QR 코드 1개에 1개의 URL 생성 가능함으로 2개를 생성하여 사용자 버전과 관리자 버전으로 구분하여 보다 제공되는 서비스 품질을 높일 수 있음



# 7. 자체 평가 의견
## 7-1. 개별 평가
- 한현진
  - 프로젝트를 진행하면서, 처음에 security와 csrf로 인해 오류가 많이 떠서, 제가 맡은 프로젝트를 진행하는데 시간이 지체되는 것 같아서 security와 csrf 를 제외해놓고 프로젝트를 시작했는데, 나중에 깃으로 합칠 때 수정하는 과정이 더 길어졌던 것 같습니다. 그래서 조금 지체 되더라도 처음부터 체계적으로 빼놓는 부분 없이 프로젝트를 시작하고 진행하는 것이 중요하다고 생각했습니다.
- 이유나
  - 이번 프로젝트를 통해 Git을 활용한 협업 방식과 conflict 대응 능력을 배웠고, 체계적인 설계 과정과 팀원들과의 적극적인 소통이 역시나 가장 중요하다는 것을 느끼게 되었습니다. 프로젝트 초기에 스프링 부트에 대한 막연한 두려움이 있었지만 느리더라도 꾸준히 공부하면 해낼 수 있다는 자신감을 얻게 되었습니다.
- 임성민
  - 항공권 조회부터 결제까지 모든 과정을 하나의 연결된 과정으로 진행하다보니 하나의 페이지가 이동될때마다 이전에 입력한 데이터를 계속 가져와서 탑승객정보 입력부분과 결제부분에서 DB에 저장했는데 값을 계속 가져오는 부분이 어려웠고 더 좋은 방법이 있을지도 모르겠다는 고민을 해봤습니다. 그리고 처음으로 API를 적용해 봤는데 적용하기 전에는 어려울까봐 걱정했지만 생각보다 괜찮았고 다양한 기술을 적용해 볼 수 있는 좋은 경험이었습니다.
 
- 정슬기
  - Spring Boot라는 프레임워크를 처음 활용해서 만드는 프로젝트이다 보니 구조 파악하는데 어려움이 있었고, 특히 Security에서 user principal을 커스텀해서 사용해야 하는 부분이 다소 복잡해 시간이 오래 걸렸던 것 같습니다. 타임리프라는 새로운 템플릿 엔진을 사용하면서 익숙치 않아 당황스러운 부분도 있었지만 시간이 지날 수록 점차 적응하고 있었고 팀원들과 프로젝트 목표치에 가까워져갈 때는 성취감을 느낄 수 있었습니다.
 

## 7-2. 종합 평가

### 한계점
- 항공권 예매, 실시간 좌석 선택, 게시판과 같은 필수 기능들은 거의 구현이 되었으나, 공항버스 예매와 같은 옵션 기능들은 구현을 하지 못하였다.


### 개선점
- 개인이 작업 할 때는 잘 되던 기능들이 깃으로 합치면 안되는 경우가 많아, security, csrf, static 과 같은 공통적으로 사용하는 파일과 코드를 처음부터 틀을 잡으며, 팀원들이 같은 개발환경에서 프로젝트를 진행한다.


### 문제해결방법
- 프로젝트 설계하는데 시간이 조금 더 걸리더라도 기간에 따른 목표치 등 기획을 철저하게 하여 중간에 변경되는 부분을 최소화 한다. 틈틈이 깃을 이용해 파일을 합치고 팀원들과 소통을 원활히 하여 오류를 줄인다.


## 참조
- Iampay API : https://api.iamport.kr/
- QR API : https://github.com/zxing/zxing
