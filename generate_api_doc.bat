@echo off
echo Generating API documentation...
echo This requires npm to be installed!

REM clear old docs
del api.md
REM Delete the combined file
del combined.graphql

set title=Playertype API

REM install graphql-markdown if not installed
if not exist node_modules\graphql-markdown (
   start cmd /C npm install graphql-markdown
)

npx graphql-markdown "http://localhost:%port%/graphql" --title "%title%" > api.md

REM wait for user input
echo API documentation generated.

REM Delete the combined file
del combined.graphql
