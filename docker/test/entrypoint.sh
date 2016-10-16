#!/bin/bash
set -e

# Run confd to render config file(s)
confd -onetime -backend env

# Run application
exec "$@"