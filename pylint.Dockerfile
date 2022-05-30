FROM ubuntu
RUN apt-get update
RUN apt-get install -y python3.9
RUN apt-get install -y pip
#RUN pip install -U pylint=2.13.8
RUN pip install -U pip setuptools wheel
RUN pip install -U pylint==2.13.8
#RUN python3 --version
RUN pylint --version
#ADD hello.py /home/hello.py
#ADD a.py /home/a.py
CMD echo "this is test"
