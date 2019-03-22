# GPRS-Tunneling-Protocol-packet-simulator

## About

This project was developed to test problematic test cases in 2G/3G mobile packet network by generating and sending GTP packets.

Packets are formed in accordance to [ETSI specification](https://www.etsi.org/deliver/etsi_ts/129000_129099/129060/12.06.00_60/ts_129060v120600p.pdf).


## Running

git clone https://github.com/vsabz/GPRS-Tunneling-Protocol-packet-simulator.git

cd GPRS-Tunneling-Protocol-packet-simulator

javac GTPMessageBuildingBlocks/*.java GTPMessages/*.java UI/*.java Utilities/*.java

java UI/SGSNUI
