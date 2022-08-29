# Git 명령어

- config : 사용자 등록
ex) git config --global user.name "사용자 이름"

- init : .git 디렉토리 생성
ex) git init

- add : 파일을 staged 상태(commit 대기 상태)로 만듬
ex) git add. or git add 파일명

- log : commit 목록 출력
ex) git log

- commit : 변경 내용을 로컬에 반영
ex) git commit -m '커밋 내용' (aM 사용시 add와 commit 둘다 적용)

- remote : 원격 저장소와 연동
ex) 1. git remote add origin'git url' 2. git remote -v 3. git remote remove origin

- push : remote 된 원격 저장소에 내용을 반영함
ex) git push origin main

- pull : 원격 조장소의 내용을 가져옴
ex) git pull pair main

