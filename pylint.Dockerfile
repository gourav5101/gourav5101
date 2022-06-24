FROM python:3.9.6-slim-buster

RUN mkdir -p /code
WORKDIR /code

RUN set -eux \
    && pip install -U pip setuptools wheel \
    && pip install -U pylint==2.13.8 \
    && pip freeze \
    && rm -rf /root/.cache/pip

COPY docker-pylint-entrypoint.sh /docker-pylint-entrypoint.sh

ENTRYPOINT ["/docker-pylint-entrypoint.sh"]
