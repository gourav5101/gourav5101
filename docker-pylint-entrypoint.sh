#!/bin/bash
if [ -z "$1" ];
then
    codepath=/code
else
    codepath=$1
fi

echo $codepath

echo "Running pylint"
pylint --version
pip freeze
export PYTHONPATH=${codepath}
pylint --output-format=parseable --report=yes --fail-under=8 ${codepath} --exit-zero --ignore=test > pylint.log
sed -i 's|/code/||g' pylint.log
