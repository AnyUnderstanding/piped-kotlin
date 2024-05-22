#!/bin/bash


TEST_PATH="$PWD/../src/test/kotlin"

if [ -z $1 ]; then
    echo "Please provide a test case name"
    exit 1
fi

CAPITALIZED_TEST_NAME="${1^}"
LOWER_CASE_TEST_NAME="${1,}"

mkdir -p "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"
mkdir -p "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/out

touch "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/out/piped.pd
touch "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/out/llvm.ll

cp KtTemplate "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/"$CAPITALIZED_TEST_NAME"Test.kt
sed -i -e "s/<testName>/$LOWER_CASE_TEST_NAME/g" "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/"$CAPITALIZED_TEST_NAME"Test.kt
sed -i -e "s/<TestName>/$CAPITALIZED_TEST_NAME/g" "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/"$CAPITALIZED_TEST_NAME"Test.kt



cp PipedTemplate "$TEST_PATH"/"$LOWER_CASE_TEST_NAME"/"$CAPITALIZED_TEST_NAME".pd
