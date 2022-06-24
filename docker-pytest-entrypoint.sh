#!/bin/bash
if [ -z "$1" ];
then
    codepath=/code
else
    codepath=$1
fi

echo $codepath

echo "Running pytest"
pytest --version
pip freeze
export PYTHONPATH=${codepath}
export MODULE_HOME=${codepath}
export ENVIRONMENT=test
pytest test --suppress-tests-failed-exit-code -v --junitxml="pytest_result.xml"
