from channels.generic.websocket import AsyncWebsocketConsumer
import json

class VitalSignsConsumer(AsyncWebsocketConsumer):
    async def connect(self):
        self.patient_id = self.scope['url_route']['kwargs']['patient_id']
        self.group_name = f'patient_{self.patient_id}'

        await self.channel_layer.group_add(
            self.group_name,
            self.channel_name
        )

        await self.accept()

    async def disconnect(self, close_code):
        await self.channel_layer.group_discard(
            self.group_name,
            self.channel_name
        )

    async def receive(self, text_data):
        pass  # Not needed for one-way communication

    async def send_vital_signs(self, event):
        data = event['data']
        await self.send(text_data=json.dumps(data))
