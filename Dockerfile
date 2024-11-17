version: '3'
services:
  selenium-hub:
    image: selenium/hub:4.6.0
    container_name: selenium-hub
    ports:
      - "8080:8080"

  chrome:
    image: selenium/node-chrome:4.6.0
    container_name: chrome
    shm_size: 2gb
    depends_on:
      - selenium-hub
    environment:
      - SE_EVENT_BUS_HOST=selenium-hub
      - SE_EVENT_BUS_PUBLISH_PORT=4442
      - SE_EVENT_BUS_SUBSCRIBE_PORT=4443
