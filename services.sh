#!/usr/bin/env bash

function start() {
  docker compose -f ./infrastructure/local/docker-compose.yml up -d
}

function stop() {
  docker compose -f ./infrastructure/local/docker-compose.yml down
}

action=${1:-start}

case "$action" in
     start)
        start
        ;;
     stop)
        stop
        ;;
esac