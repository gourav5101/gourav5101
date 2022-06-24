FROM python:3.9

RUN mkdir -p /code
WORKDIR /code

RUN set -eux \
    && pip install -U pip setuptools wheel \
    && pip install -U pytest==6.2.3 pytest-custom_exit_code==0.3.0 \
    && pip freeze \
    && rm -rf /root/.cache/pip

COPY docker-pylint-entrypoint.sh /docker-pytest-entrypoint.sh

ENTRYPOINT ["/docker-pytest-entrypoint.sh"]
