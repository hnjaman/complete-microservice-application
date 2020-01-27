brew update
brew install rabbitmq
export PATH=$PATH:/usr/local/opt/rabbitmq/sbin

echo "To have launchd start rabbitmq now and restart at login:"
echo "  brew services start rabbitmq"
echo "Or, if you don't want/need a background service you can just run:"
echo "  rabbitmq-server"
