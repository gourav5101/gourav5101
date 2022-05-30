FROM python:3.9.6-slim-buster
RUN pip install -U pip setuptools wheel
RUN pip install -U pylint==2.13.8
#RUN pylint abc.py
RUN python --version
RUN python --version
