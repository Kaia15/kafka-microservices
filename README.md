# UtubeServices

## Overview
- Created a RESTful backend server using Spring Boot, comprising 4 crucial microservices (email, user, notification,
and subscription) essential for a Youtube-liked platform.
- Enabled real-time notifications for users using Kafka (Kafka topic, producer, consumer).
  
> for naming error, subscribee = who got subscribed from their subscribers, which means they are one of channel owners, and have their subscribers from their channels.

> B subscribe to A => A has subscriber B, and B has subscriber A, A was subscribed by B.

Kafka             |  REST Api(s) & Kafka
:-------------------------:|:-------------------------:
![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/5084f154-b4b3-4cbe-9209-38bebb0961d2) | ![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/4fd569db-c126-4042-b5aa-7944c2f0be6c)

### 1. Send notification email to new user (new subscriber) - Server 

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/cdf040f4-f846-4b19-b025-1d9df008c012)

### 2. Send notification email to new user (new subscriber) - Dummy STMP Server

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/798a656b-b490-4016-98cf-a879ecaf015f)

### 3. Modify subscribed user

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/18e547c7-865e-4a64-b2da-50f2bbc4ee14)

### 4. Automatic email to alert new updates (after user modification such as password reset, linked-email update)

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/e394b1f3-6a60-4c63-87c0-657fb20ea6cd)

### 5. Automatically update subscriber and subscribee count (information) with streaming kafka 

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/ab12e2ce-f3fe-4c85-bd82-7d77b7861347)

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/5cddf92f-5137-4c1a-a37a-8a4a207e64aa)

![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/fb4003e1-8fe2-42b5-9605-bd24c1cec4e0)

### 6. The collaboration of three services to send notification, create subscription and update subscribers at same time.
![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/ac7302a0-6481-459b-9ac1-17625114a76d)
![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/4c9fa9cd-6c4a-4f35-bc85-2a2ad2dce97e)
![image](https://github.com/Kaia15/kafka-microservices/assets/86872685/9b991bd2-4af1-428d-9ad9-2b9dd5afdbb0)

