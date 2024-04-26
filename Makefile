.PHONY: start
start:
	docker compose -f ./infrastructure/local/docker-compose.yml up -d
run-migrations:
	./gradlew -Dflyway.configFiles=src/main/resources/application.properties :flywayMigrate
repair-migrations:
	./gradlew -Dflyway.configFiles=src/main/resources/application.properties :flywayRepair
