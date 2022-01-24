#!/usr/bin/env python3

from requests import get

year = input("Jahr: ")

map = get(f"https://feiertage-api.de/api/?jahr={year}").json()

bw = map["BW"]

for name, info in bw.items():
    date = info["datum"].split("-")

    year = date[0]
    month = date[1]
    day = date[2]

    print(f"{name} am {day}.{month}.{year}")
