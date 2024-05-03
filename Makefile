.PHONY: start
start:
	docker compose -f ./infrastructure/local/docker-compose.yml up -d