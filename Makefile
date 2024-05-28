.PHONY: build start stop
.DEFAULT_GOAL: build

build:
	./run-build.sh

start:
	./services.sh start

stop:
	./services.sh stop