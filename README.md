[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1aa8b5c5e51844e4b3ae8d48116f25fe)](https://www.codacy.com/app/blaec/topjava?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=blaec/topjava&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/blaec/topjava.svg?branch=master)](https://travis-ci.org/blaec/topjava)
[![Dependency Status](https://www.versioneye.com/user/projects/5a17ec360fb24f213f8d5650/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/5a17ec360fb24f213f8d5650)

Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) without frontend.

The task is:

Build a voting system for deciding where to have lunch.

2 types of users: admin and regular users
Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
Menu changes each day (admins do the updates)
Users can vote on which restaurant they want to have lunch at
Only one vote counted per user
If user votes again the same day:
If it is before 11:00 we asume that he changed his mind.
If it is after 11:00 then it is too late, vote can't be changed
Each restaurant provides new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it.