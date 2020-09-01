# OAuth-service-Springboot

## Register endpoint
~~~
curl --location --request POST 'http://localhost:8080/oauth/users' \
--header 'Content-Type: application/json' \
--data-raw '{
  "userName": "hari",
  "password": "hari@123",
  "email": "hari.singhar@gmail.com",
  "mobile": "9856683254"
}'

~~~

## Generate accesstoken endpoint
~~~~
Generate Access Token:
curl --location --request POST 'http://localhost:8080/oauth/token?username=hari&password=hari@123&grant_type=password' \
--header 'Authorization: Basic dGVzdDp0ZW1w'
~~~


## Validate endpoint
~~~
curl --location --request POST 'http://localhost:8080/oauth/check_token?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTg5NjkyNTgsInVzZXJfbmFtZSI6ImhhcmkiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMjg5Mjc3MjktMjViZi00NWZmLTk5ODAtYjU1ZTM4Y2NiYzYxIiwiY2xpZW50X2lkIjoidGVzdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.CNjCm3h7JDNMs_CtxkgvnJOW2bhMN6oct5vQk70g7M0' \
--header 'Authorization: Basic dGVzdDp0ZW1w'
~~~

## Get Access token from Refresh token endpoint
~~~
curl --location --request POST 'http://localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJoYXJpIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6IjA0YzIxZDQ3LTIyMTctNGYwNi04YjlkLTdiNDBkMzM2YTg5ZCIsImV4cCI6MTU5ODk3MDYwNiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6IjA5YWI1MmE4LTg5YTktNDdhMy05NjNmLWM4OWFjN2Y2MzJkZiIsImNsaWVudF9pZCI6InRlc3QifQ.tg3YMrTcGXZttCetO6ORlknI5J_Q2OEK97ZYFWYr-bM' \
--header 'Authorization: Basic dGVzdDp0ZW1w'
~~~

Client Application implementation : https://youtu.be/qgLE1jx7fmk
