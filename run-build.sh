#!/usr/bin/env bash

echo "Building the project..."
./gradlew clean build

echo "Running all tests..."
./gradlew test